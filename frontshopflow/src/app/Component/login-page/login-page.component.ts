import { Component } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../../Service/User/user.service';
import { HeaderService } from '../../Service/Header/header.service';

@Component({
  selector: 'app-login-page',
  imports: [MatInputModule, MatButtonModule, MatCardModule, MatFormFieldModule, ReactiveFormsModule],
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.css'
})
export class LoginPageComponent {

  loginForm!: FormGroup;
  token: any;

  constructor(private formBuilder: FormBuilder, private router: Router, private httpUserService: UserService, private headerService: HeaderService) {
    this.loginForm = this.formBuilder.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]]
    });
  }

  errorMessage: boolean = false;


  onSubmit() {
    if (this.loginForm.valid) {
      let user = this.loginForm.value;
      this.httpUserService.postLogin(user).subscribe({
        next: data => {  
          this.token = data;
          console.log(this.token.token);
          this.headerService.setToken(this.token.token);
          this.errorMessage = false;
          this.router.navigate(['/']);
        },
        error: error => {console.log(error), this.errorMessage = true; }
      });
    }
  }

  navigateBack() {
    this.router.navigate(['/']);
  }
}
