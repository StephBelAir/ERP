import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LotDialogComponent } from './lot-dialog.component';

describe('LotDialogComponent', () => {
  let component: LotDialogComponent;
  let fixture: ComponentFixture<LotDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LotDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LotDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
