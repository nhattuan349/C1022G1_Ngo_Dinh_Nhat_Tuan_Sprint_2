import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductListComponent} from "./product-list/product-list.component";
import {ShoppingCartComponent} from "./shopping-cart/shopping-cart.component";
import {AdminGuard} from "../sercurity/admin.guard";
import {ProductDetailComponent} from "./product-detail/product-detail.component";


const routes: Routes = [
  {path: '', component: ProductListComponent},
  {path: 'detail/:id', component: ProductDetailComponent},
  {canActivate: [AdminGuard],
    path: 'shopping-cart', component: ShoppingCartComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule { }
