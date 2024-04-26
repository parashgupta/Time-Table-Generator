import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onLogin(username: string, password: string): void {
    if (!username || !password) {
    } else if (username === 'parash' && password === '123') {
      this.router.navigate(['/home']);
      console.log('Login successful!');
    } else {
      console.log('Invalid username or password');
    }
  }
}
