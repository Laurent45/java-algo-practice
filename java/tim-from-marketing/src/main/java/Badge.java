class Badge {
    public String print(Integer id, String name, String department) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Badge name is null or blank");
        }

        StringBuilder sb = new StringBuilder();
        if (id != null) {
            sb.append("[").append(id).append("] - ");
        }

        sb.append(name);
        sb.append(" - ");

        sb.append(department == null ? "OWNER" : department.toUpperCase());

        return sb.toString();

    }
}
