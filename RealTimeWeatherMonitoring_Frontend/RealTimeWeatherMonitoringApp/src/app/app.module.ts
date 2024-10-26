import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { WeatherMonitoringComponent } from './weather-monitoring/weather-monitoring.component';
import { WeatherMonitoringService } from './weather-monitoring.service';

@NgModule({
  declarations: [
    AppComponent,
    WeatherMonitoringComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
    
  ],
  providers: [WeatherMonitoringService],
  bootstrap: [AppComponent]
})
export class AppModule { }
