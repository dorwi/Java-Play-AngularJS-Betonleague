In the */etc/ansible/hosts* we can set the hosts which should be affected by the ansible script. With

```
[betonleague_hosts]
vagrant ansible_ssh_host=192.168.11.11 ansible_ssh_user=vagrant
```

we have set the vagrant vm as the betonleague host.
To run the script:

```
ansible-playbook ansible-script.yml
```