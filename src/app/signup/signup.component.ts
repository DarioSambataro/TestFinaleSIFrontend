import {Component, Input, Output} from '@angular/core';
import {FormsModule, NgForm} from "@angular/forms";
import {UtenteService} from "../services/utente.service";
import {SignupRequest} from "../model/SignupRequest";
import {Router, RouterLink} from "@angular/router";
import EventEmitter from "node:events";
import {CommonModule, NgIf} from "@angular/common";

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [
    FormsModule,
    NgIf,
    CommonModule,
    RouterLink
  ],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {
  @Input() signuprequest : SignupRequest = new SignupRequest();


  constructor(public utenteService:UtenteService, public router: Router) {

  }
  ngOnInit(form: NgForm) {
    console.log(form);
  }


  submit(form: NgForm) {
    console.log(this.signuprequest.firstname);
    console.log(this.signuprequest.lastname);
    console.log(this.signuprequest.email);
    console.log(this.signuprequest.password);
    if(form.valid) {
      this.utenteService.signup(this.signuprequest).subscribe(result => {
          console.log(result);
          this.router.navigate(['/']);
        }
      )
    }
  }
}
