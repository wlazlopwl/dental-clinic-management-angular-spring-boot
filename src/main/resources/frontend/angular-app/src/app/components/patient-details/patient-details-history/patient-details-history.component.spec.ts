import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientDetailsHistoryComponent } from './patient-details-history.component';

describe('PatientDetailsHistoryComponent', () => {
  let component: PatientDetailsHistoryComponent;
  let fixture: ComponentFixture<PatientDetailsHistoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientDetailsHistoryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientDetailsHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
