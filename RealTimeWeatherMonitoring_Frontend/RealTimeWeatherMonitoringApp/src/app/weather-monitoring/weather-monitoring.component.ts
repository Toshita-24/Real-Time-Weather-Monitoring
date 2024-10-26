import { Component, OnInit } from '@angular/core';
import { WeatherMonitoringService } from '../weather-monitoring.service';

@Component({
  selector: 'app-weather-monitoring',
  templateUrl: './weather-monitoring.component.html',
  styleUrls: ['./weather-monitoring.component.css']
})
export class WeatherMonitoringComponent implements OnInit {
  cities = ['Delhi', 'Mumbai', 'Chennai', 'Bangalore', 'Kolkata', 'Hyderabad'];
  selectedCity: string = 'Delhi';
  dailySummary: any;
  loading: boolean = false;
  minTemp: number | null = null;
  maxTemp: number | null = null;
  avgTemp: number | null = null;
  dominantCondition: string | null = null;

  constructor(private weatherService: WeatherMonitoringService) {}

  ngOnInit(): void {
    this.getWeatherSummary(this.selectedCity);
    this.weatherService.getDailySummaryWithDominantCondition(this.selectedCity).subscribe(response => {
      console.log('API Response:', response); // Log to check response
      this.dominantCondition = response.weather[0].main;  // Set dominant condition here
    });

    
  }

  getWeatherSummary(city: string) {
    this.loading = true;
    this.weatherService.getDailySummary(city).subscribe(
      (data) => {
        this.dailySummary = {
          city: data.name,
          date: new Date(),
          avgTemp: data.main.temp,
          maxTemp: data.main.temp_max,
          minTemp: data.main.temp_min,
          condition: data.weather[0].description
        };
        this.loading = false;
      },
      (error) => {
        console.error('Error fetching weather summary:', error);
        this.loading = false;
      }
    );
  }

  changeCity(city: string) {
    this.selectedCity = city;
    this.getWeatherSummary(city);
    this.weatherService.getDailySummaryWithDominantCondition(city).subscribe(response => {
      this.dominantCondition = response.weather[0].main;

  });
  }
}
