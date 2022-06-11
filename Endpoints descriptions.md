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
