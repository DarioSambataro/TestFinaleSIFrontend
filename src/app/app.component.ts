import { Component } from '@angular/core';
import {NavigationEnd, Router, RouterEvent, RouterLink, RouterOutlet} from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {UtenteService} from "./services/utente.service";
import {SignupComponent} from "./signup/signup.component";
import {HomeComponent} from "./home/home.component";


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, LoginComponent, CommonModule, FormsModule, RouterLink, SignupComponent, HomeComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'test_dario_sambataro';
  isLoginPage: boolean = false ;
  isHomePage: boolean = false;


  constructor(private router: Router, private utenteService: UtenteService) {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.isLoginPage = this.router.url === '/login';
        this.isHomePage = this.router.url === '/home';
      }
    })
  }

  ngOnInit(): void {
    this.utenteService.getAll().subscribe(result => {
      console.log(result);
    });
  }
}
