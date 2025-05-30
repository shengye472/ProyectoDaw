import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ProductService } from '../../../Service/Product/product.service';
import { Product } from '../../../Model/product';

@Component({
  selector: 'app-edit-product-page',
  imports: [MatButtonModule, MatInputModule, MatFormFieldModule, ReactiveFormsModule],
  templateUrl: './edit-product-page.component.html',
  styleUrl: './edit-product-page.component.css'
})
export class EditProductPageComponent {

  productForm: FormGroup;

  private product!: Product;

  constructor(
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<EditProductPageComponent>,
    private productService: ProductService,
    @Inject(MAT_DIALOG_DATA) public barCode: string
  ) { 
    this.productForm = this.fb.group({
      barCode: ['', Validators.required],
      name: ['', Validators.required],
      price_sell: [0, [Validators.required, Validators.min(0)]],
      price_buy: [0, [Validators.required, Validators.min(0)]],
      stock: [0, [Validators.required, Validators.min(0)]],
    });
  }

  ngOnInit() {
    console.log(this.barCode);
    this.getProduct(this.barCode);
  }

  getProduct(barCode: string) {
    this.productService.getProductByBarCode(barCode).subscribe({
      next: (data) => {
        this.product = data;
        this.productForm.patchValue(data);
      },
      error: (error) => {
        console.error('Error fetching product by barcode:', error);
      }
    });
  }

  submit() {
    let product: Product = this.productForm.value;
    this.productService.putProduct(this.barCode, product).subscribe({
      next: data => {
        console.log(data);
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
