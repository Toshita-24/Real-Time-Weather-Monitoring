import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WeatherMonitoringComponent } from './weather-monitoring.component';

describe('WeatherMonitoringComponent', () => {
  let component: WeatherMonitoringComponent;
  let fixture: ComponentFixture<WeatherMonitoringComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [WeatherMonitoringComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WeatherMonitoringComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
