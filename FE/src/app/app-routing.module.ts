import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {
    path: 'product',
    loadChildren: () => import('./component/product/product.module').then(module => module.ProductModule)
  },
  {
    path: 'login',
    loadChildren: () => import('./component/login/login.module').then(module => module.LoginModule)
  },
  {
    path: 'register',
    loadChildren: () => import('./component/register/register.module').then(module => module.RegisterModule)
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
