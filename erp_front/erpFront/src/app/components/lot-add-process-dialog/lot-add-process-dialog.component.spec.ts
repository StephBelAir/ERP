import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LotAddProcessDialogComponent } from './lot-add-process-dialog.component';

describe('LotAddProcessDialogComponent', () => {
  let component: LotAddProcessDialogComponent;
  let fixture: ComponentFixture<LotAddProcessDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LotAddProcessDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LotAddProcessDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
