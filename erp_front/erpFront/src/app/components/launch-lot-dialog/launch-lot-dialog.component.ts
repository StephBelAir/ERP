import {Component, OnInit} from '@angular/core';
import {FormGroup, FormControl, FormBuilder, Validators} from '@angular/forms';
import {LotService} from "../../services/lot.service";
import {ILot} from "../../interfaces/ilot";
import {MatDialogRef} from "@angular/material/dialog";


@Component({
  selector: 'app-launch-lot-dialog',
  templateUrl: './launch-lot-dialog.component.html',
  styleUrls: ['./launch-lot-dialog.component.scss']
})
export class LaunchLotDialogComponent implements OnInit {

  listLot!: ILot[];
  launchLotForm!: FormGroup;

  /*
  startLot!: Date;
  endLot!: Date;
  lotId: Number = 0;

  range = new FormGroup({
    lotNumber: new FormControl(null),
    start: new FormControl(null),
    end: new FormControl(null),
  })*/


  constructor(private formBuilder: FormBuilder,
              private lotService: LotService,
              private dialogRef: MatDialogRef<LaunchLotDialogComponent>) { }

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
            alert("Machine added successfully");
            this.launchLotForm.reset();
            this.dialogRef.close('saveProcess');
          },
          error: () => {
            alert("Error while adding the product")
          }
        })
    }

    /*
    this.startLot = this.range.value.start
    this.endLot = this.range.value.end
    this.lotService.patchLot(this.lotId, this.startLot, this.endLot) */
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
          alert("Error while fetching the Records !!")
        }
      })
  }

}
