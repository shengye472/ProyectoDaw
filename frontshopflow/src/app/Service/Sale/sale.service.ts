import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HeaderService } from '../Header/header.service';
import { Observable } from 'rxjs';
import { Sale, vending } from '../../Model/sale';

@Injectable({
  providedIn: 'root'
})
export class SaleService {

  constructor(private http: HttpClient, private headerService: HeaderService) { }

  private url = 'http://localhost:8080/api/sales';

  private head: any;

  getSales(): Observable<any>{
    this.head = this.headerService.getHeaderWithToken();
    return this.http.get<any>(this.url, { headers: this.head });
  }

  getNextSales(nextUrl: string): Observable<any> {
    this.head = this.headerService.getHeaderWithToken();
    return this.http.get<any>(nextUrl, { headers: this.head });
  }

  getSaleById(id: number): Observable<Sale> {
    this.head = this.headerService.getHeaderWithToken();
    return this.http.get<Sale>(`${this.url}/${id}`, { headers: this.head });
  }

  deleteSale(id: number): Observable<any> {
    this.head = this.headerService.getHeaderWithToken();
    return this.http.delete<any>(`${this.url}/${id}`, { headers: this.head });
  }

  postSale(sale: vending): Observable<any> {
    this.head = this.headerService.getHeaderWithToken();
    return this.http.post<any>(this.url, sale, { headers: this.head });
  }
}
