import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatDialogRef} from "@angular/material/dialog"
import {ProcessService} from "../../services/process.service";
import Swal from "sweetalert2";


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
            Swal.fire("Process added successfully");
            this.processForm.reset();
            this.dialogRef.close('save');
          },
          error: () => {
            Swal.fire("Error while adding the Process")
          }
        })
    }
  }


}
