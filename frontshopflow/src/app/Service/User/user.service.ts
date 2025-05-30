import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../../Model/user';
import { Router } from '@angular/router';
import { BehaviorSubject, Subject } from 'rxjs';
import { HeaderService } from '../Header/header.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private router: Router, private headerService: HeaderService) { }

  url = 'http://localhost:8080/api/auth';

  private login = new BehaviorSubject<boolean>(false);

  logger = this.login.asObservable();

  postLogin(user: User) {
    let data = this.http.post(this.url + '/login', user);
    if (data) {
      this.login.next(true);
      console.log('Login successful');
    }
    return data;
  }

  logout() {
    this.headerService.clearToken();
    this.login.next(false);
  }
}
