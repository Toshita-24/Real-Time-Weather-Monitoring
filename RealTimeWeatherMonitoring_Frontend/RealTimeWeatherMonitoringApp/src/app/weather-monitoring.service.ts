import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class WeatherMonitoringService {
  private apiUrl = 'https://api.openweathermap.org/data/2.5/weather';
  private apiKey = '99835a97d4a5e38462072a6c9ae821d0';
  private unit = 'metric';

  constructor(private http: HttpClient) {}

  fetchWeatherData(): Observable<any> {
    return this.http.get(`${this.apiUrl}/fetch`);
  }

  // Fetch daily summary for a specific city
  getDailySummary(city: string): Observable<any> {
    const url = `${this.apiUrl}?q=${city}&units=${this.unit}&appid=${this.apiKey}`;
    return this.http.get<any>(url).pipe(
      tap(response => {
        console.log('Weather API Response:', response);
      }),
      catchError((error: HttpErrorResponse) => {
        console.error('Error fetching weather data:', error);
        return throwError(() => error);
      })
    );
  }

  // Fetch daily summary with dominant condition
  getDailySummaryWithDominantCondition(city: string): Observable<any> {
    const url = `${this.apiUrl}?q=${city}&units=${this.unit}&appid=${this.apiKey}`;
    return this.http.get<any>(url).pipe(
      tap(response => {
        console.log('Daily Summary for', city, ':', response);
      }),
      catchError((error: HttpErrorResponse) => {
        console.error('Error fetching daily summary:', error);
        return throwError(() => error);
      })
    );
  }
}
