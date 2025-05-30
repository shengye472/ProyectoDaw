import { Detail } from "./detail";

export interface Sale {
    id: number;
    total: number;
    date: string;
    details: Detail[];
}
export interface vending {
    total: number;
    details: Detail[];
}
