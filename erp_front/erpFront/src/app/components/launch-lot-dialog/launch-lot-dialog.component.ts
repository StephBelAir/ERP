import {Component, OnInit} from '@angular/core';
import {FormGroup, FormControl, FormBuilder, Validators} from '@angular/forms';
import {LotService} from "../../services/lot.service";
import {ILot} from "../../interfaces/ilot";
import {MatDialogRef} from "@angular/material/dialog";
import Swal from 'sweetalert2';


@Component({
  selector: 'app-launch-lot-dialog',
  templateUrl: './launch-lot-dialog.component.html',
  styleUrls: ['./launch-lot-dialog.component.scss']
})
export class LaunchLotDialogComponent implements OnInit {

  listLot!: ILot[];
  launchLotForm!: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private lotService: LotService,
              private dialogRef: MatDialogRef<LaunchLotDialogComponent> ) { }

  ngOnInit(): void {
    this.launchLotForm = this.formBuilder.group({
      id : ['',Validators.required],
      startDate : ['',Validators.required],
      endDate : ['',Validators.required]
    })
    this.getAllLots()
  }



  launchLot() {
    console.log(this.launchLotForm.value)
     if (this.launchLotForm.valid) {
      this.lotService.patchLot(this.launchLotForm.value)
        .subscribe({
          next: (res) => {
            Swal.fire("Machine added successfully");
            this.launchLotForm.reset();
            this.dialogRef.close('save');
          },
          error: () => {
            Swal.fire("Error while adding the product")
          }
        })
    }

  }

  getAllLots() {
    this.lotService.getLot()
      .subscribe({
        next: (res) => {
          console.log(res);
          this.listLot = res
          console.log("Process Loaded", this.listLot)
        },
        error: (err) => {
          Swal.fire("Error while fetching the Records !!")
        }
      })
  }


}
