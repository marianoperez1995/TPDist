create login loginTpo WITH
PASSWORD='loginTpo',
default_database = tpoad,
check_policy=off

use tpoad
sp_changedbowner loginTpo