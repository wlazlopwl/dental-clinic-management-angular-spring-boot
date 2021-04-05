import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientDetailsGeneralComponent } from './patient-details-general.component';

describe('PatientDetailsGeneralComponent', () => {
  let component: PatientDetailsGeneralComponent;
  let fixture: ComponentFixture<PatientDetailsGeneralComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientDetailsGeneralComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientDetailsGeneralComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
