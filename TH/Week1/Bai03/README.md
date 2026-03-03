a) Đối tượng BankAccount
- Định danh: là tên biến tham chiếu đến đối tượng myAccount
- Trạng thái: là giá trị được gắn cho các thuộc tính của đối tượng khi được tham chiếu tới định danh
    - accountNumber: "101202303"
    - ownerName: "Nguyen Van A"
    - balance: ban đầu là 0, sau khi gọi deposit(500) thì thành 500 và withdraw thì bằng 350
- Hành vi: là các phương thức đối tượng có thể sử dụng
    - openAccount()
    - deposit()
    - withdraw()
b) Đối tượng SmartFan
Đối tượng 1:
- Định danh: livingRoomFan.
- Trạng thái:
    - brand: "Xiaomi"
    - isPowerOn: true
    - speedLevel: 2
- Hành vi: turnOn(), turnOff(), setSpeed()

Đối tượng 2:
- Định danh: bedroomFan
- Trạng thái:
    - brand: "Xiaomi"
    - isPowerOn: true
    - speedLevel: 0