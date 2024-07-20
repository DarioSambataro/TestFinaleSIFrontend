import {Component, Input, NgModule, Output} from '@angular/core';
import {FormsModule, NgForm} from "@angular/forms";
import {LoginRequest} from "../model/LoginRequest";
import EventEmitter from "node:events";
import {UtenteService} from "../services/utente.service";
import {Router, RouterLink} from "@angular/router";
import {CommonModule, NgIf} from "@angular/common";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule,
    RouterLink,
    NgIf,
    CommonModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  @Input() loginrequest:LoginRequest = new LoginRequest();



  constructor(public utenteService:UtenteService, public router: Router) {

  }
  private isLogged: boolean;


  submit(form: NgForm) {
    console.log(this.loginrequest.email);
    console.log(this.loginrequest.password);
    if(form.valid){
      this.utenteService.login(this.loginrequest).subscribe(result => {
          this.isLogged = true;
          console.log(result);
          console.log("Loggato: "+ this.isLogged);
          this.router.navigate(['/']);
        }
      )
    }
  }
}
