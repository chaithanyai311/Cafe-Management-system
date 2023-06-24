import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerserviceService {

  private loginUrl = "http://localhost:8080/customers/";
  private addCustomerUrl = "http://localhost:8080/addcustomer";
  private updateCustomerUrl = "http://localhost:8080/updatecustomer";

  constructor(private http: HttpClient) { }
  
  getCustomerDetails(username, password)
  {
    return this.http.get(this.loginUrl+username+"/"+password);
  }

  addCustomer(addcustomer: Object):Observable<Object>{
    return this.http.post(`${this.addCustomerUrl}`,addcustomer);
  }

  updateCustomer(updatecustomer: Object):Observable<Object>{
    return this.http.put(`${this.updateCustomerUrl}`,updatecustomer);
  }

  
}
