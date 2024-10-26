import { TestBed } from '@angular/core/testing';

import { WeatherMonitoringService } from './weather-monitoring.service';

describe('WeatherMonitoringService', () => {
  let service: WeatherMonitoringService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WeatherMonitoringService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
