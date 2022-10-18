import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EndLotDialogComponent } from './end-lot-dialog.component';

describe('EndLotDialogComponent', () => {
  let component: EndLotDialogComponent;
  let fixture: ComponentFixture<EndLotDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EndLotDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EndLotDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
