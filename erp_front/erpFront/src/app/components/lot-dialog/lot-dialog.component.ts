import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {LotService} from "../../services/lot.service";
import {MatDialogRef} from "@angular/material/dialog"
import Swal from 'sweetalert2';



@Component({
  selector: 'app-lot-dialog',
  templateUrl: './lot-dialog.component.html',
  styleUrls: ['./lot-dialog.component.scss']
})
export class LotDialogComponent implements OnInit {

  lotForm !: FormGroup;

  constructor(private formBuilder: FormBuilder, private lotService: LotService, private dialogRef: MatDialogRef<LotDialogComponent>) {
  }

  ngOnInit(): void {
    this.lotForm = this.formBuilder.group({
      productName: ['', Validators.required],
      width: ['', Validators.required],
      quantity: ['', Validators.required],
      length: ['', Validators.required],
      type: ['']
    })
  }

  addLot() {
    if (this.lotForm.valid) {
      this.lotService.postLot(this.lotForm.value)
        .subscribe({
          next: (res) => {
            Swal.fire({ title:"Lot added successfully",
              icon: "success"});
            this.lotForm.reset();
            this.dialogRef.close('save');
          },
          error: () => {
            Swal.fire({ title:"Error while fetching the Records !!",
              icon: "error",})          }
        })
    }
  }

}
