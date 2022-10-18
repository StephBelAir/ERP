import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LaunchLotDialogComponent } from './launch-lot-dialog.component';

describe('LaunchLotDialogComponent', () => {
  let component: LaunchLotDialogComponent;
  let fixture: ComponentFixture<LaunchLotDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LaunchLotDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LaunchLotDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
