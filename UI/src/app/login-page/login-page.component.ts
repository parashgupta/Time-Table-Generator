import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  username: string = '';
  password: string = '';
  
  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onLogin(): void {
    if (!this.username || !this.password) {
      //this.showSnackbar('Please enter both username and password', 'error');
    } else if (this.username === 'parash' && this.password === '123') {
      this.router.navigate(['/home']);
      console.log('Login successful!');
    } else {
      console.log('Invalid username or password');
      //this.showSnackbar('Invalid username or password', 'error');

    }
  }

}
