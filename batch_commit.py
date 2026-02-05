import subprocess, sys
p = subprocess.run(["git", "status", "--porcelain"], capture_output=True, text=True)
lines = [l[3:] if len(l)>=3 else l for l in p.stdout.splitlines()]
files = [l for l in lines if l.strip()]
if not files:
    print('No changes to commit')
    sys.exit(0)
batch_size = 10
i = 0
count = 0
while i < len(files):
    batch = files[i:i+batch_size]
    print(f"Staging {len(batch)} files (indexes {i+1}-{i+len(batch)})...")
    subprocess.check_call(["git", "add", "--"] + batch)
    msg = f"Add batch commit: files {i+1} to {i+len(batch)}"
    subprocess.check_call(["git", "commit", "-m", msg])
    i += batch_size
    count += 1
print('\nCreated commits:')
subprocess.run(["git", "log", "-n", str(count), "--name-only", "--pretty=format:%h %s"])