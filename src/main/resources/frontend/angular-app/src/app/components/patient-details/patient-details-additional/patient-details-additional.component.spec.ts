import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientDetailsAdditionalComponent } from './patient-details-additional.component';

describe('PatientDetailsAdditionalComponent', () => {
  let component: PatientDetailsAdditionalComponent;
  let fixture: ComponentFixture<PatientDetailsAdditionalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientDetailsAdditionalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientDetailsAdditionalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
