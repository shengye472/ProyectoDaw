import { Component, Inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Product } from '../../../Model/product';
import { ProductService } from '../../../Service/Product/product.service';
import { UserService } from '../../../Service/User/user.service';

@Component({
  selector: 'app-show-product-page',
  imports: [MatButtonModule, FormsModule],
  templateUrl: './show-product-page.component.html',
  styleUrl: './show-product-page.component.css'
})
export class ShowProductPageComponent {

  logger!: boolean;

  constructor(private dialogRef: MatDialogRef<ShowProductPageComponent>, private userService: UserService  , @Inject(MAT_DIALOG_DATA) public product: Product) { 

  }

  ngOnInit() {
    this.userService.logger.subscribe({
      next: (data: boolean) => { this.logger = data; }
    });
  }

  cancel() {
    this.dialogRef.close();
  }

}
