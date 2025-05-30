import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginatorModule } from '@angular/material/paginator';
import { Product } from '../../../Model/product';
import { ProductService } from '../../../Service/Product/product.service';
import { UserService } from '../../../Service/User/user.service';
import { NewProductPageComponent } from '../new-product-page/new-product-page.component';
import { EditProductPageComponent } from '../edit-product-page/edit-product-page.component';
import { ShowProductPageComponent } from '../show-product-page/show-product-page.component';



@Component({
  selector: 'app-products-page',
  imports: [
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatIconModule,
    MatPaginatorModule,
    MatDialogModule
  ],
  templateUrl: './products-page.component.html',
  styleUrl: './products-page.component.css'
})
export class ProductsPageComponent {

  constructor(
    private productService: ProductService,
    private userService: UserService,
    private formBuilder: FormBuilder,
    private dialog: MatDialog
  ) { }


  logger!: boolean;

  searchForm!: FormGroup;

  products!: Product[];
  
  nextUrl!: string;
  previusUrl!: string;
  currentPage!: number;
  allpages!: number;

  ngOnInit() {
    this.getAllProducts();

    this.userService.logger.subscribe({
      next: (data: boolean) => { this.logger = data; }
    });

    this.searchForm = this.formBuilder.group({
      barCode: [''],
    });

  }

  getAllProducts() {
    this.productService.getProducts().subscribe({
      next: (data) => {
        this.products = data.data;
        this.nextUrl = data.next;
        this.previusUrl = data.previous;
        this.currentPage = data.currentPage;
        this.allpages = this.totalPages(data.total, data.pageSize);
      },
      error: (error) => {
        console.error('Error fetching products:', error);
      }
    });
  }

  getNextProducts(url: string) {
    this.productService.getNextProducts(url).subscribe({
      next: (data) => {
        this.products = data.data;
        this.nextUrl = data.next;
        this.previusUrl = data.previous;
        this.currentPage = data.currentPage;
        this.allpages = this.totalPages(data.total, data.pageSize);
      },
      error: (error) => {
        console.error('Error fetching next products:', error);
      }
    });
  }

  getProductByBarCode() {
    let barCode = this.searchForm.value.barCode;
    if (!barCode) { return; }
    this.productService.getProductByBarCode(barCode).subscribe({
      next: (data) => {
        this.dialog.open(ShowProductPageComponent, {
          width: '500px',
          data: data
        })
      },
      error: (error) => {
        console.error('Error fetching product by barcode:', error);
      }
    });
  }

  New() {
    console.log("New Product");
    this.dialog.open(NewProductPageComponent, {
      width: '500px',
    })

    this.reload();
  };

  totalPages(total: number, pageSize: number): number {
    return Math.ceil(total / pageSize);
  }

  reload() {
    this.dialog.afterAllClosed.subscribe(() => {
      this.getAllProducts();
    });
  }

  Edit(barCode: string) {
    this.dialog.open(EditProductPageComponent, {
      width: '500px',
      data: barCode
    })

    this.reload();
  }

  deleteProduct(barCode: string) {
    this.productService.deleteProduct(barCode).subscribe({
      next: (data) => {
        console.log("Product deleted successfully");
        this.getAllProducts();
      },
      error: (error) => {
        console.error('Error deleting product:', error);
      }
    });
  }
}
