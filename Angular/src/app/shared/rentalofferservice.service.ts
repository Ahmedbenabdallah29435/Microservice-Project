import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RentalOffer } from '../modele/rentalOffer/rentaloffer.modele';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class RentalofferserviceService {

  constructor(private http: HttpClient, private userService:UserService) { }
  private BASE_URL = 'http://localhost:8081/rentaloffers/GetAllRentalOffers';

  private BASE_URL_DELETE = 'http://localhost:8081/rentaloffers/deleteRentalOffer';
  private BASE_URL_AJOUT = 'http://localhost:8081/rentaloffers/addRentalOffer';
  private BASE_URL_UPDATE = 'http://localhost:8000/rentaloffers/update-RentalOffer';
  private BASE_URL_GETBYID = 'http://localhost:8000/rentaloffers/';
  private BASE_URL_AVAILABLE_OFFERS = 'http://localhost:8000/rentaloffers/GetAvailableRentalOffers/';
  private BASE_URL_TRI_DES='http://localhost:8000/rentaloffers/triDesc';
  private BASE_URL_TRI_ASC='http://localhost:8000/rentaloffers/tri';
  getOffers(): Observable<any> {
    return this.http.get(`${this.BASE_URL}`);
  }
  TriOffersDesc(): Observable<any> {
    return this.http.get(`${this.BASE_URL_TRI_DES}`);
  }
  TriOffersAsc(): Observable<any> {
    return this.http.get(`${this.BASE_URL_TRI_ASC}`);
  }


  deleteOfferdeleteOffer(id: number): Observable<any> {
    return this.http.delete(`${this.BASE_URL_DELETE}/${id}`, { responseType: 'text' });

  }

  addRentalOffer(rentalOffer: RentalOffer, id:number): Observable<any> {
    return this.http.post<RentalOffer>(`${this.BASE_URL_AJOUT}/${id}`, rentalOffer)
  }
 
  getOffreById(id :any){
    console.log('gg' , id)
    return this.http.get('http://localhost:8000/rentaloffers/'+id)
  }
  getChiffreByUser(id :any){
    console.log('gg' , id)
    return this.http.get(' http://localhost:8000/rentalcontract/revenue/'+id)
  }
  getAvailableOffers(date1 :any,date2:any){
    return this.http.get(this.BASE_URL_AVAILABLE_OFFERS +date1+"/"+date2)
  }
  updateOffre(data:any){
    return this.http.put('http://localhost:8000/rentaloffers/updateRentalOffer' ,data)
  }

  getDisponible(id : any){
    return this.http.get('http://localhost:8000/rentaloffers/Disponibilite/'+id)
  }

  
}
