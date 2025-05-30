import { Routes } from '@angular/router';
import { ErrorPageComponent } from './Component/error-page/error-page.component';
import { HomePageComponent } from './Component/home-page/home-page.component';
import { LoginPageComponent } from './Component/login-page/login-page.component';
import { ProductsPageComponent } from './Component/Product/products-page/products-page.component';
import { SalesPageComponent } from './Component/Sale/sales-page/sales-page.component';
import { VendingPageComponent } from './Component/vending-page/vending-page.component';

export const routes: Routes = [
    {path: "", component: ProductsPageComponent},
    {path: "login", component: LoginPageComponent},
    {path: "products", component: ProductsPageComponent},
    {path: "sales", component: SalesPageComponent},
    {path: "vending", component: VendingPageComponent},
    {path: "**", component: ErrorPageComponent}
];
