----------------------------------------
|               Usuario                |
----------------------------------------
| - banco: Davank                      |
| - grupos: List<Grupo>                |
| - primerNombre: String               |
| - segundoNombre: String              |
| - primerApellido: String             |
| - segundoApellido: String            |
| - nombreCompleto: String             |
| - dni: int                           |
| - contraseña: String                 |
| - dinero: double                     |
| - cuenta: Cuenta                     |
----------------------------------------
| + nombre(): String                   |
| + dni(): int                         |
| + dinero(): double                   |
----------------------------------------

----------------------------------------
|               Grupo                 |
----------------------------------------
| - lider: Usuario                     |
| - nombre: String                     |
| - integrantes: List<Usuario>         |
| - saldo: double                      |
| - registroDepositos: HashMap<Usuario, Double> |
----------------------------------------
| + integrantes(): List<Usuario>       |
| + saldo(): double                    |
----------------------------------------

----------------------------------------
|               Cuenta                 |
----------------------------------------
| - titular: Usuario                   |
| - numeroCuenta: int                  |
| - saldo: double                      |
----------------------------------------
| + titular(): Usuario                 |
| + numeroCuenta(): int                |
| + saldo(): double                    |
----------------------------------------

----------------------------------------
|               Davank                 |
----------------------------------------
| - nombre: String                     |
| - gruposDeAhorros: List<Grupo>       |
| - usuariosDelBanco: List<Usuario>    |
| - cuentasDelBanco: List<Cuenta>      |
----------------------------------------
| + registrarPersona(): void           |
----------------------------------------
