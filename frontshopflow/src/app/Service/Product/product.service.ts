import { Injectable } from '@angular/core';
import { HeaderService } from '../Header/header.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../../Model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient ,private headerService: HeaderService) { }

  private url = 'http://localhost:8080/api/products'

  private head: any;

  getProducts(): Observable<any>{
    return this.http.get<any>(this.url);
  }

  getNextProducts(urls: string): Observable<any>{
    return this.http.get<any>(urls);
  }

  getProductByBarCode(barCode: string): Observable<any> {
    return this.http.get<any>(`${this.url}/${barCode}`);
  }

  postProduct(product: Product): Observable<Product> {
    this.head = this.headerService.getHeaderWithToken();
    return this.http.post<Product>(this.url, product, { headers: this.head });
  }

  putProduct(barCode: String ,product: Product): Observable<Product> {
    this.head = this.headerService.getHeaderWithToken();
    console.log(this.head);
    return this.http.put<Product>(`${this.url}/${barCode}`, product, { headers: this.head });
  }

  deleteProduct(barCode: String): Observable<any> {
    this.head = this.headerService.getHeaderWithToken();
    return this.http.delete<any>(`${this.url}/${barCode}`, { headers: this.head });
  }
}
