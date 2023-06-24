import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContentComponent } from './content/content.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { DisplayComponent } from './display/display.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { UpdateProductComponent } from './update-product/update-product.component';

import { UserComponent } from './user/user.component';
import { OrderComponent } from './order/order.component';
// import { ViewComponent } from './view/view.component';

const routes: Routes = [
  {path: "", component: LoginComponent},
  {path: "home", component: HomeComponent},
  {path: "register", component: CreateCustomerComponent},
  {path: "updatecustomer", component: UpdateCustomerComponent},
  {path: "user", component: UserComponent},
  {path: "login", component: LoginComponent},
  {path: "addproduct", component:CreateProductComponent },
  {path: "display", component:DisplayComponent },
  {path: "contents", component:ContentComponent },
   {path: "updateproduct", component: UpdateProductComponent },
   {path: "order", component: OrderComponent },

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
