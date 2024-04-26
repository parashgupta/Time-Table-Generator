import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private router: Router, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
  }

  onLogin(username: string, password: string): void {
    if (!username || !password) {
      this.showSnackbar('Please enter both username and password', 'error-snackbar');
    } else if (username === 'parash' && password === '123') {
      this.router.navigate(['/home']);
      console.log('Login successful!');
    } else {
      console.log('Invalid username or password');
      this.showSnackbar('Invalid username or password', 'error-snackbar');
    }
  }


  private showSnackbar(message: string, panelClass: string): void {
    const config = new MatSnackBarConfig();
    config.duration = 5000;
    config.panelClass = [panelClass];
    config.verticalPosition = 'top';
    this.snackBar.open(message, 'Close', config);
  }

  

}
