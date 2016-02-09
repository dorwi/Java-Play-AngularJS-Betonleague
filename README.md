# BETONLEAGUE
==============

The platform for presenting and keeping track of the results of the amateur football league called Betonleague. It is a non-profit organization, basically friends and friends of friends playing football every week.

### AngularJS
==============

The frontend is written in Angular 1.*, also Bootstrap is used.

### PLAY framework
==============

The backend is written in Java Play 2.* framework. Postgresql is used for storing the data.

### Ansible
==============

For auto deployment Ansible is used. More info in the Ansible directory.

### Blackbox
==============

To be able to version control every file, I opted for Blackbox. It is a very useful utility from encrypting sensitive files, using gpg. It's easy to control who can decrypt these files. In future, the ansible script will be set up, such that from there the file can be decrypted.

Some useful commands:
`cd` to the git repo (betonleague) and run
```
blackbox_initialize
git commit -m'INITIALIZE BLACKBOX' keyrings /home/dori/Workspace/betonleague/.gitignore
```
this will create blackbox in the repo. Now we can register file for encryption:
```
blackbox_register_new_file FILE_NAME
blackbox_edit_start FILE_NAME
blackbox_edit_end FILE_NAME
```

All commands:

| Name: | Description: |
| --- | --- |
| `blackbox_edit` | Decrypt, run $EDITOR, re-encrypt a file |
| `blackbox_edit_start` | Decrypt a file so it can be updated |
| `blackbox_edit_end` | Encrypt a file after blackbox_edit_start was used |
| `blackbox_cat` | Decrypt and view the contents of a file |
| `blackbox_diff` | Diff decrypted files against their original crypted version |
| `blackbox_initialize` | Enable blackbox for a GIT or HG repo |
| `blackbox_register_new_file` | Encrypt a file for the first time |
| `blackbox_deregister_file` | Remove a file from blackbox |
| `blackbox_list_files` | List the files maintained by blackbox |
| `blackbox_decrypt_all_files` | Decrypt all managed files (INTERACTIVE) |
| `blackbox_postdeploy` | Decrypt all managed files (batch) |
| `blackbox_addadmin` | Add someone to the list of people that can encrypt/decrypt secrets |
| `blackbox_removeadmin` | Remove someone from the list of people that can encrypt/decrypt secrets |
| `blackbox_shred_all_files` | Safely delete any decrypted files |
| `blackbox_update_all_files` | Decrypt then re-encrypt all files. Useful after keys are changed |
| `blackbox_whatsnew` | show what has changed in the last commit for a given file |

