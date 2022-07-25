import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardStudentComponent } from './student-dashboard.component';

describe('StudentDashboardComponent', () => {
  let component: DashboardStudentComponent;
  let fixture: ComponentFixture<DashboardStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DashboardStudentComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(DashboardStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
