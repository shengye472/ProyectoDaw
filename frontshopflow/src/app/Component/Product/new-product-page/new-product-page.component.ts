import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogRef } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ProductService } from '../../../Service/Product/product.service';
import { Product } from '../../../Model/product';

@Component({
  selector: 'app-new-product-page',
  imports: [MatButtonModule, MatInputModule, MatFormFieldModule, ReactiveFormsModule],
  templateUrl: './new-product-page.component.html',
  styleUrl: './new-product-page.component.css'
})
export class NewProductPageComponent {
  productForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<NewProductPageComponent>,
    private productService: ProductService
  ) {
    this.productForm = this.fb.group({
      barCode: ['', Validators.required],
      name: ['', Validators.required],
      price_sell: [0, [Validators.required, Validators.min(0)]],
      price_buy: [0, [Validators.required, Validators.min(0.00)]],
      stock: [0, [Validators.required, Validators.min(0)]],
    });
  }

  submit() {
    let product: Product = this.productForm.value;
    this.productService.postProduct(product).subscribe({
      next: data => {
        this.dialogRef.close();
      },
      error: error => {
        console.log(error);
      }
    })
  }

  cancel() {
    this.dialogRef.close();
  }

}
