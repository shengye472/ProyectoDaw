import { Product } from "./product";

export interface Detail {
    quantity: number;
    subtotal: number;
    products: Product;
}
