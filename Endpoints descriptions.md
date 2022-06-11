## Endpoints descriptions
### My User Controller :- 

    @GetMapping
        public ResponseEntity<List<MyUser>> getUsers(){
            logger.info("Get users");
            return ResponseEntity.status(200).body(myUserService.getUsers());
        }
#####  Get all users registered in database.

     @PostMapping
        public ResponseEntity<API> addUser(@RequestBody @Valid MyUser myUser){
            logger.info("Add user");
            myUserService.addUser(myUser);
            return ResponseEntity.status(201).body(new API("User Added",201));
        }
#####  Add user to database.

    @PutMapping("/update/{userid}")
    public ResponseEntity<API> update(@RequestBody @Valid MyUser myUser,@PathVariable Integer userid){
            logger.info("Update user");
            myUserService.update(myUser,userid);
            return ResponseEntity.status(201).body(new API("User updated",201));
        }
##### Update a spicifice user by userID.

        @DeleteMapping("/delete/{userid}")
        public ResponseEntity<API> delete(@PathVariable Integer userid){
            logger.info("Delete user");
            myUserService.delete(userid);
            return ResponseEntity.status(201).body(new API("User deleted",201));
        }
##### Delete a spicifice user by userID.

     @PostMapping("/checkreservation")
        public ResponseEntity<API> securCheck(@RequestBody String carPlate){
            logger.info("Check if user is have reservation ");
            myUserService.securCheck(carPlate);
            return ResponseEntity.status(201).body(new API("Guest car is register ",201));
        }
##### Check if the guest have reservation.


### Park Controller :- 

    @GetMapping
    public ResponseEntity<List<Park>> getParks(){
        logger.info("Get parks");
        return ResponseEntity.status(200).body(parkService.getParks());
    }
#####  Get all parks registered in database.

     @PostMapping("/owner/add")
    public ResponseEntity<API> ownerAddPark(@RequestBody @Valid Park park){
        logger.info("Add park");
        parkService.addPark(park);
        return ResponseEntity.status(201).body(new API("Park ready to use",201));
    }
#####  Owner add new park.

    @PutMapping("/update/{parkid}")
    public ResponseEntity<API> update(@RequestBody @Valid Park park,@PathVariable Integer parkid){
        logger.info("Update park");
        parkService.update(park,parkid);
        return ResponseEntity.status(201).body(new API("Park updated",201));
    }
##### Update a spicifice park by parkID.

        @DeleteMapping("/delete/{parkid}")
    public ResponseEntity<API> delete(@PathVariable Integer parkid){
        logger.info("Delete park");
        parkService.delete(parkid);
        return ResponseEntity.status(201).body(new API("Park deleted",201));
    }
##### Delete a spicifice park by parkID.


### Payment Controller :- 

    @GetMapping
    public ResponseEntity<List<Payment>> getPayments(){
        logger.info("Get payments");
        return ResponseEntity.status(200).body(paymentService.getPayments());
    }
#####  Get all payments.

     @PostMapping
    public ResponseEntity<API> addPayment(@RequestBody @Valid Payment payment){
        logger.info("Add payment");
        paymentService.addPayment(payment);
        return ResponseEntity.status(201).body(new API("Payment Added",201));
    }
#####  Add new payment.


### Reservation Controller :- 

    @GetMapping
    public ResponseEntity<List<Reservation>> getReservations(){
        logger.info("Get reservations");
        return ResponseEntity.status(200).body(reservationService.getReservations());
    }
#####  Get all reservations.

     @PostMapping
    public ResponseEntity<API> addReservation(@RequestBody @Valid Reservation reservation){
        logger.info("Add reservation");

        reservationService.addReservation(reservation);
        return ResponseEntity.status(201).body(new API("Reservation Added",201));
    }
#####  Add new reservation.

    @PutMapping("/update/{reservationid}")
        public ResponseEntity<API> update(@RequestBody @Valid Reservation reservation,@PathVariable Integer reservationid){
            logger.info("Update reservations");
            reservationService.update(reservation, reservationid);
            return ResponseEntity.status(201).body(new API("Reservation updated",201));
        }
##### Update a spicifice reservation by reservationID.

    @DeleteMapping("/delete/{reservationid}")
        public ResponseEntity<API> delete(@PathVariable Integer reservationid){
            logger.info("Delete reservations");
            reservationService.delete(reservationid);
            return ResponseEntity.status(201).body(new API("Reservation deleted",201));
        }
##### Delete a spicifice reservation by reservationID.
