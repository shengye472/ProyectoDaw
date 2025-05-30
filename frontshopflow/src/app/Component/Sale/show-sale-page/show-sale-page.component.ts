import { CommonModule } from '@angular/common';
import { Component, Inject } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Sale } from '../../../Model/sale';

@Component({
  selector: 'app-show-sale-page',
  imports: [ CommonModule, MatButtonModule],
  templateUrl: './show-sale-page.component.html',
  styleUrl: './show-sale-page.component.css'
})
export class ShowSalePageComponent {

  constructor(private dialogRef: MatDialogRef<ShowSalePageComponent>, @Inject(MAT_DIALOG_DATA) public venta: Sale ) { 
  }  

  cancel() {
    this.dialogRef.close();
  }

}
