import { Component } from '@angular/core';
import { Detail } from '../../Model/detail';
import { MatIconModule } from '@angular/material/icon';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { ProductService } from '../../Service/Product/product.service';
import { Sale, vending } from '../../Model/sale';
import { SaleService } from '../../Service/Sale/sale.service';

@Component({
  selector: 'app-vending-page',
  imports: [
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatIconModule
  ],
  templateUrl: './vending-page.component.html',
  styleUrl: './vending-page.component.css'
})
export class VendingPageComponent {

  listOfDetails: Detail[] = [];

  TotalAmount: number = 0;

  searchForm!: FormGroup;

  constructor(
    private productService: ProductService,
    private saleService: SaleService,
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit() {
    this.searchForm = this.formBuilder.group({
      barCode: [''],
    });
  }

  getDetail() {
    const barCode = this.searchForm.value.barCode;
    if (!barCode) {
      return
    }
    const index = this.listOfDetails.findIndex(detail => detail.products.barCode === barCode);
    if (index !== -1) {
      const updatedDetail: Detail = {
        ...this.listOfDetails[index],
        quantity: this.listOfDetails[index].quantity + 1,
        subtotal: (this.listOfDetails[index].quantity + 1) * this.listOfDetails[index].products.price_sell
      };
      this.listOfDetails[index] = updatedDetail;
      this.calculateTotal();
      this.searchForm.setValue({ barCode: '' });
    } else {
      this.productService.getProductByBarCode(barCode).subscribe({
        next: (product) => {
          if (product) {
            const newDetail: Detail = {
              products: product,
              quantity: 1,
              subtotal: product.price_sell
            };
            this.listOfDetails.push(newDetail);
            this.calculateTotal();
            this.searchForm.setValue({ barCode: '' });
          }
        },
        error: (err) => {
          console.error('Producto no encontrado', err);
        }
      });
    }
  }

  calculateTotal() {
    this.TotalAmount = this.listOfDetails.reduce((acc, detail) => acc + detail.subtotal, 0);
  }

  removeDetail(barCode: string) {
    const index = this.listOfDetails.findIndex(detail => detail.products.barCode === barCode);
    this.listOfDetails.splice(index, 1);
    this.calculateTotal();
  }

  clearDetails() {
    this.listOfDetails = [];
    this.TotalAmount = 0;
    this.searchForm.setValue({ barCode: '' });
  }

  sendSale() {
    if (this.listOfDetails.length === 0) {
      alert('No hay productos para vender');
      return;
    }

    let sale: vending = {
      details: this.listOfDetails,
      total: this.TotalAmount
    };

    
    this.saleService.postSale(sale).subscribe({
      next: (response) => {
        this.clearDetails();
      },
      error: (err) => {
        console.error('Error al registrar la venta', err);
        alert('Error al registrar la venta');
      }
    })

  
  }

}


