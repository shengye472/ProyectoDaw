import { Component } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatMenuModule} from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { Router } from '@angular/router';
import { UserService } from '../../Service/User/user.service';

@Component({
  selector: 'app-header',
  imports: [ MatIconModule, MatToolbarModule, MatMenuModule, MatButtonModule],
  standalone: true,
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  logger!: boolean;

  constructor( private router: Router, private userService: UserService) {
  }
  
  ngOnInit() {

    this.userService.logger.subscribe((data: boolean) => {
      this.logger = data;
    });
    
    
    console.log(this.logger)
  }

  home() {
    this.router.navigate(['/']);
  }

  productos() {
    this.router.navigate(['/products']);
  }

  iniciarSesion() {
    this.router.navigate(['/login']);

  }

  cerrarSesion() {
    this.userService.logout();
    this.home();
  }

  ventas(){
    this.router.navigate(['/sales']);
  }

  caja(){
    this.router.navigate(['/vending']);
  }
}
