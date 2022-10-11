import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatDialogRef} from "@angular/material/dialog"
import {ProcessService} from "../../services/process.service";


@Component({
  selector: 'app-process-dialog',
  templateUrl: './process-dialog.component.html',
  styleUrls: ['./process-dialog.component.scss']
})
export class ProcessDialogComponent implements OnInit {

  processForm !: FormGroup;


  constructor(private formBuilder : FormBuilder, private processService : ProcessService, private dialogRef : MatDialogRef<ProcessDialogComponent> ) { }

  ngOnInit(): void {
    this.processForm = this.formBuilder.group({
      processName : ['', Validators.required]
    })
  }

  addProcess() {
    if (this.processForm.valid){
      this.processService.postProcess(this.processForm.value)
        .subscribe({
          next: (res) => {
            alert("Process added successfully");
            this.processForm.reset();
            this.dialogRef.close('save');
          },
          error: () => {
            alert("Error while adding the Process")
          }
        })
    }
  }


}
