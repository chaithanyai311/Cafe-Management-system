import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { SliderComponent } from './slider/slider.component';
import { ProductsComponent } from './products/products.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { UserComponent } from './user/user.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { DisplayComponent } from './display/display.component';
import { ContentComponent } from './content/content.component';
import { OrderComponent } from './order/order.component';
import { UpdateProductComponent } from './update-product/update-product.component';


// import { ViewComponent } from './view/view.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    HomeComponent,
    CreateCustomerComponent,
    SliderComponent,
    ProductsComponent,
    UpdateCustomerComponent,
    UserComponent,
    CreateProductComponent,
    DisplayComponent,
    ContentComponent,
    OrderComponent,
    UpdateProductComponent

    
    // ViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
