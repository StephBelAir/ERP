import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcessAddMachinesDialogComponent } from './process-add-machines-dialog.component';

describe('ProcessAddMachinesDialogComponent', () => {
  let component: ProcessAddMachinesDialogComponent;
  let fixture: ComponentFixture<ProcessAddMachinesDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProcessAddMachinesDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcessAddMachinesDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
