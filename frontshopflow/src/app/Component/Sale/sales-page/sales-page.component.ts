import { Component } from '@angular/core';
import { SaleService } from '../../../Service/Sale/sale.service';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { Sale } from '../../../Model/sale';
import { CommonModule } from '@angular/common';
import { ShowSalePageComponent } from '../show-sale-page/show-sale-page.component';

@Component({
  selector: 'app-sales-page',
  imports: [
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatIconModule,
    MatDialogModule,
    CommonModule
  ],
  templateUrl: './sales-page.component.html',
  styleUrl: './sales-page.component.css'
})
export class SalesPageComponent {

  constructor(private saleService: SaleService, private dialog: MatDialog, private formBuilder: FormBuilder) { }

  searchForm!: FormGroup;

  sales!: Sale[];

  nextUrl!: string;
  previusUrl!: string;
  currentPage!: number;
  allpages!: number;

  ngOnInit() {
    this.getSales();

    this.searchForm = this.formBuilder.group({
      id: [''],
    });
  }

  totalPages(total: number, pageSize: number): number {
    return Math.ceil(total / pageSize);
  }

  getSales() {
    this.saleService.getSales().subscribe({
      next: (data) => {
        console.log(data);
        this.sales = data.data;
        console.log(this.sales);

        this.nextUrl = data.next;
        this.previusUrl = data.previous;
        this.currentPage = data.currentPage;
        this.allpages = this.totalPages(data.total, data.pageSize);
      },
      error: (error) => {
        console.error(error);
      }
    });
  }

  getNextSales(url: string) {
    this.saleService.getNextSales(url).subscribe({
      next: (data) => {
        console.log(data);
        this.sales = data.data;
        console.log(this.sales);

        this.nextUrl = data.next;
        this.previusUrl = data.previous;
        this.currentPage = data.currentPage;
        this.allpages = this.totalPages(data.total, data.pageSize);
      },
      error: (error) => {
        console.error(error);
      }
    });
  }

  getSaleById() {
    let id = this.searchForm.value.id;
        if (!id) { return; }
        this.saleService.getSaleById(id).subscribe({
          next: (data) => {
            console.log(data);
            this.dialog.open(ShowSalePageComponent , {
              width: '500px',
              data: data
            })
          },
          error: (error) => {
            console.error(error);
          }
        });
  }

  ShowDetails(sale: Sale) {
    this.dialog.open(ShowSalePageComponent, {
      width: '500px',
      data: sale
    });
  }

  deleteSale(id: number) {
    this.saleService.deleteSale(id).subscribe({
      next: (data) => {
        console.log(data);
        this.getSales();
      },
      error: (error) => {
        console.error('Error deleting sale:', error);
      }
    });
  }
}
